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
              //System.out.println(latchange);
              //System.out.println(lonchange);
    	StringBuffer codedPoints = new StringBuffer();
              codedPoints.append(doubleToASCII(latchange));
              codedPoints.append(doubleToASCII(lonchange));
    	int i=1;
              if (gpsPoints.length!=1){
                do{
                    //System.out.println(codedPoints.toString());
                    startingPoint = gpsPoints[i-1];
                    endPoint = gpsPoints[i];
                    latchange = endPoint.getLatitude() - startingPoint.getLatitude();
                    lonchange = endPoint.getLongitude() - startingPoint.getLongitude();
                    codedPoints.append(doubleToASCII(latchange));
                    codedPoints.append(doubleToASCII(lonchange));
                            //System.out.println(latchange);
                            //System.out.println(lonchange);
                    i = i+1;
                }while(i<gpsPoints.length);
              }
    	
              //System.out.println(codedPoints.toString());
    	return codedPoints.toString();
    }

    private String doubleToASCII(double change){
    	change = change*100000;
              //System.out.println(change);
    	BigDecimal bigDecimal = new BigDecimal(Double.toString(change)).setScale(0, RoundingMode.HALF_UP);
    	double roundedValue = bigDecimal.doubleValue();
              //System.out.println(roundedValue);
    	String binaryValue = decimalToBinary(roundedValue);
              //System.out.println(binaryValue);
    	int[][] chunks = binaryToChunks(binaryValue);
    	int[] decimalValue = chunksToDecimal(chunks);
      //for (int i=0;i<decimalValue.length;i++) {
        //System.out.println(decimalValue[i]);
      //}
              //System.out.println(' ');
              //System.out.println(decimalValue[1]);
              //System.out.println(decimalValue[2]);
              //System.out.println(decimalValue[3]);
              //System.out.println(decimalValue[4]);
              //System.out.println(decimalValue[5]);
    	return decimalToASCII(decimalValue);
    }

    private String decimalToBinary(double decimal){
    	String binaryValue;
    	int roundedValue = (int) decimal;
       //System.out.println(roundedValue);
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
              //System.out.println(lenOfBinary);
    	while (lenOfBinary%5!=0){
    		sb = new StringBuffer();
    		sb.append("0").append(binary);
    		binary = sb.toString();
                            lenOfBinary = binary.length();
                            //System.out.println(binary);
    	}
              //System.out.println(binary);
    	int numberOfChunks = lenOfBinary/5;
              //System.out.println(numberOfChunks);
    	int[][] chunks = new int[numberOfChunks][6];
    	for(int i=0;i<numberOfChunks;i++)
    		for(int j=0;j<5;j++){  
    		chunks[numberOfChunks-1-i][4-j]=Integer.parseInt(String.valueOf(binary.charAt(5*i+j)));
                            //System.out.print(chunks[i][j]);
                            //System.out.print(i);
                            //System.out.println(j);
    	}
    	chunks[numberOfChunks-1][5]=0;
    	for (int i=0;i<numberOfChunks-1;i++) {
    		chunks[i][5]=1;
    	}
              //for(int i=0;i<numberOfChunks;i++)
                    //for(int j=0;j<6;j++){  
                            //System.out.print(chunks[i][j]);
                   // }
              //System.out.println(' ');
                    
                    
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
       //System.out.println(sb.toString());
    	return sb.toString();
    }

}
