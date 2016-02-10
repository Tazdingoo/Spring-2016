package edu.nyu.cs9053.homework2;

import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 * User: blangel
 * Date: 8/17/14
 * Time: 9:02 AM
 *
 * Implements the Polyline Algorithm defined here
 * {@literal https://developers.google.com/maps/documentation/utilities/polylinealgorithm}
 */
public class PolylineEncoder {

    public String encodePolyline(Gps[] gpsPoints) {
    	Gps startingPoint;
    	Gps endPoint = gpsPoints[0];
    	double latchange = endPoint.getLatitude();
    	double lonchange = endPoint.getLongitude();
    	StringBuffer codedPoints = new StringBuffer();
              codedPoints.append(doubleToASCII(latchange));
              codedPoints.append(doubleToASCII(lonchange));
    	int i=1;
              if (gpsPoints.length!=1){
                do{
                    startingPoint = gpsPoints[i-1];
                    endPoint = gpsPoints[i];
                    latchange = endPoint.getLatitude() - startingPoint.getLatitude();
                    lonchange = endPoint.getLongitude() - startingPoint.getLongitude();
                    codedPoints.append(doubleToASCII(latchange));
                    codedPoints.append(doubleToASCII(lonchange));
                    i = i+1;
                }while(i<gpsPoints.length);
              }
    	
    	return codedPoints.toString();
    }

    private String doubleToASCII(double change){
    	change = change*100000;
    	BigDecimal bigDecimal = new BigDecimal(Double.toString(change)).setScale(0, RoundingMode.HALF_UP);
    	double roundedValue = bigDecimal.doubleValue();
    	String binaryValue = decimalToBinary(roundedValue);
    	int[][] chunks = binaryToChunks(binaryValue);
    	int[] decimalValue = chunksToDecimal(chunks);
    	return decimalToASCII(decimalValue);
    }

    private String decimalToBinary(double decimal){
    	String binaryValue;
    	int roundedValue = (int) decimal;
    	roundedValue = roundedValue << 1;
    	if (roundedValue<0) {
    		roundedValue = ~roundedValue;
    	}
    	binaryValue = Integer.toBinaryString(roundedValue);
    	return binaryValue;
    }
    private int[][] binaryToChunks(String binary){
    	StringBuffer sb = null;
	int lenOfBinary = binary.length();
    	while (lenOfBinary%5!=0){
    		sb = new StringBuffer();
    		sb.append("0").append(binary);
    		binary = sb.toString();
                            lenOfBinary = binary.length();
    	}
    	int numberOfChunks = lenOfBinary/5;
    	int[][] chunks = new int[numberOfChunks][6];
    	for(int i=0;i<numberOfChunks;i++)
    		for(int j=0;j<5;j++){  
    		chunks[numberOfChunks-1-i][4-j]=Integer.parseInt(String.valueOf(binary.charAt(5*i+j)));
    	}
    	chunks[numberOfChunks-1][5]=0;
    	for (int i=0;i<numberOfChunks-1;i++) {
    		chunks[i][5]=1;
    	}
                  
    	return chunks;


    }
    private int[] chunksToDecimal(int[][] chunks){
    	int[] decimalValue = new int[chunks.length];
    	for (int i=0;i<chunks.length;i++){
    		decimalValue[i] = 0;
    		int multiple = 1;
    		for (int j=0;j<6;j++) {
    			decimalValue[i] = decimalValue[i] + multiple*chunks[i][j];
    			multiple = multiple * 2;
    		}
    		decimalValue[i] = decimalValue[i] + 63;
    	}
    	return decimalValue;

    }
    private String decimalToASCII(int[] decimal){
    	StringBuffer sb = new StringBuffer();
    	for (int output : decimal) {
        	sb.append(Character.toChars(output));
              char[] outputChar = Character.toChars(output);
              //if (outputChar[0]=='\\'){
                //sb.append(Character.toChars(output));
              //}	
    	}
    	return sb.toString();
    }

}
