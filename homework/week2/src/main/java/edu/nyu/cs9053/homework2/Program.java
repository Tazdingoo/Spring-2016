package edu.nyu.cs9053.homework2;
//import static org.junit.Assert.assertEquals;
/**
 * User: blangel
 * Date: 8/17/14
 * Time: 10:21 AM
 */
public class Program {

    public static void main(String[] args) {
        //check input format
        try{
            boolean gpsEnter = args[0].equals("gps");
        }
        catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            System.out.println("Invalid argument");
            System.exit(0);
            }
        //mode select
        boolean gpsEnter = args[0].equals("gps");
        boolean annuityEnter = args[0].equals("annuity");
        if(gpsEnter){
            gpsMode(args);
        }
        else if(annuityEnter){
            annuityMode(args);
        }
        else{
            System.out.println("Invalid argument");
            return;
        }
    }
    private static void gpsMode(String[] args) {
        try{
            boolean checkEnter = args[1].equals("gps");
        }
        catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            System.out.println("Invalid argument");
            System.exit(0);
            }
        //split input
        int numberOfPoints = args.length-1;
        Gps[] points = new Gps[numberOfPoints];
        for (int i=0;i<numberOfPoints;i++) {
	    double lat = 0; 
                  double lon = 0;
            String[] latAndLons = args[i+1].split(",");
	    int pointDimensions = latAndLons.length;
        //check input format
            try {
                lat = Double.valueOf(latAndLons[0]);
                lon = Double.valueOf(latAndLons[1]);
            }
            catch(NumberFormatException numberFormatException) {
            System.out.println("Invalid argument");
            System.exit(0);
            }
            if (!(lat >= -180 && lat <= 180 && lon >= -180 && lon <= 180 && pointDimensions==2)) {
            System.out.println("Invalid argument");
            System.exit(0);
            }
            points[i] = new Gps(lat,lon);
        }
        PolylineEncoder encodePoints = new PolylineEncoder();
        System.out.println(encodePoints.encodePolyline(points));
    	
    }

    private static void annuityMode(String[] args) {
        //check input format
        try{
            boolean checkEnter = args[1].equals("gps");
        }
        catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            System.out.println("Invalid argument");
            System.exit(0);
            }
        //split input
        double[] annuityInput = new double[3];
        int yearsInput;
        boolean compoundEnter = args[1].equals("compound");
        if (compoundEnter) {
            if (args.length!=5) {
                System.out.println("Invalid argument");
                System.exit(0);
            }
            for (int i=0;i<3;i++) {
                if (isNumber(args[i+2])) {
                    annuityInput[i] = Double.valueOf(args[i+2]);
                }
                else{
                    System.out.println("Invalid argument");
                    System.exit(0);
                }
            }
            yearsInput = (int) annuityInput[2];
            AnnuityCalculator computeAnnuity = new AnnuityCalculator();
            //calculator mode select
            if (yearsInput==15) {
                System.out.println(computeAnnuity.computeMonthlyCompoundedFutureValueOfAnnuityIn15Years(annuityInput[0], annuityInput[1]));
            }
            else if (yearsInput==30){
                System.out.println(computeAnnuity.computeMonthlyCompoundedFutureValueOfAnnuityIn30Years(annuityInput[0], annuityInput[1]));
            }
            else {
                System.out.println(computeAnnuity.computeMonthlyCompoundedFutureValueOfAnnuity(annuityInput[0],annuityInput[1], yearsInput));
            }
        }
        else{
            if (args.length!=4) {
                System.out.println("Invalid argument");
                System.exit(0);
            }
            for (int i=0;i<3;i++) {
                if (isNumber(args[i+1])) {
                    annuityInput[i] = Double.valueOf(args[i+1]);
                }
                else{
                    System.out.println("Invalid argument");
                    System.exit(0);
                }
            }
            yearsInput = (int) annuityInput[2];
            AnnuityCalculator computeAnnuity = new AnnuityCalculator();
            if (yearsInput==15) {
                System.out.println(computeAnnuity.computeFutureValueOfAnnuityIn15Years(annuityInput[0], annuityInput[1]));
            }
            else if (yearsInput==30){
                System.out.println(computeAnnuity.computeFutureValueOfAnnuityIn30Years(annuityInput[0], annuityInput[1]));
            }
            else {
                System.out.println(computeAnnuity.computeFutureValueOfAnnuity(annuityInput[0], annuityInput[1], yearsInput));
            }
        }
    }

    private static boolean isNumber(String args){
        Boolean strResult = args.matches("-?[0-9]+.*[0-9]*");  
        return strResult;
    }


}
