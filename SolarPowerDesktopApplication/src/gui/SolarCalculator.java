package gui;

import java.lang.Math;
import java.text.DecimalFormat;

public class SolarCalculator {

    /*
     * All values that are percentage in the form are assumed to be between 0-1
     * It must be modified before being placed into these methods
     *
     * Orientation is assumed as degrees
     */
    public void /*For now*/ parsePanelBanks() {
    }

    public static double efficiencyCalc(double orientation) {
        return .17 * Math.cos(Math.toRadians(orientation)) + .83;
    }

    public static double roundNumber(double result) {
        DecimalFormat format = new DecimalFormat("#.##");
        return Double.parseDouble(format.format(result));
    }
//Returns an un-rounded daily generation

    public static double calculateDailyGeneration(double sysSize, double invEff, double hoursSun,
            double orientation, double panelEff) {
        double eff = efficiencyCalc(orientation);
        double result = sysSize * invEff * hoursSun * eff * panelEff;
        // Orientation maths time!
        return result;
    }

    //Returns a rounded daily generation
    public static double calculateDailyGenerationRound(double sysSize, double invEff, double hoursSun,
            double orientation, double panelEff) {
        double result = calculateDailyGeneration(sysSize, invEff, hoursSun, orientation, panelEff);
        return roundNumber(result);
    }

    //Returns an un-rounded annual generation
    public double calculateAnnualGeneration(double sysSize, double invEff, double hoursSun,
            double orientation, double panelEff) {
        double result = calculateDailyGeneration(sysSize, invEff, hoursSun, orientation, panelEff);
        //Doesn't take leap years into account
        return result *= 365;
    }

    //Returns a rounded annual generation
    public double calculateAnnualGenerationRound(double sysSize, double invEff, double hoursSun,
            double orientation, double panelEff) {
        double result = calculateAnnualGeneration(sysSize, invEff, hoursSun, orientation, panelEff);
        return roundNumber(result);
    }

    //Returns an un-rounded generation for 'years' years.
    public double calculateGeneration(int years, double sysSize, double invEff, double hoursSun,
            double orientation, double panelEffDrop) {
        double result = 0;
        double panelEff = 1;
        for (int i = 0; i < years; i++) {
            result += calculateAnnualGeneration(sysSize, invEff, hoursSun, orientation, panelEff);
            panelEff -= panelEffDrop;
        }
        return result;
    }

    //Returns an rounded generation for 'years' years.
    public double calculateGenerationRound(int years, double sysSize, double invEff, double hoursSun,
            double orientation, double panelEffDrop) {
        double result = calculateGeneration(years, sysSize, invEff, hoursSun, orientation, panelEffDrop);
        return roundNumber(result);
    }

    public double calculateDailyCost(double cost, double power) {
        return cost * power;
    }

    public double calculateAnnualCost(double cost, double power) {
        return calculateDailyCost(cost, power) * 365; //No leap years
    }
}