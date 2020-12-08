package poc.krish.hf;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.io.FileInputStream;
import java.io.InputStream;
import com.amazonaws.util.IOUtils;
public class CaptureImage {
	/*public static void main(String[] args) throws IOException {
        Regions clientRegion = Regions.DEFAULT_REGION;
        String bucketName = "imageuploadandprocessings3bucket";
        //String stringObjKeyName = "*** String object key name ***";
        String fileObjKeyName = "index/input1.jpg";
        String fileName = "C:\\Users\\Bijoy\\Desktop\\input1.jpg";
        
        String photo="C:\\Users\\Bijoy\\Desktop\\input1.jpg";

        //String photo="C:\\Users\\Krish\\eclipse-workspace\\HelloFuture\\WebContent\\input.jpg";
		  InputStream inputStream = new FileInputStream(new File(photo));
		 

        try {
        	AmazonS3 s3Client=AmazonS3ClientBuilder.defaultClient();
        	
            // Upload a file as a new object with ContentType and title specified.
            //PutObjectRequest request = new PutObjectRequest(bucketName, fileObjKeyName, new File(fileName));
        	ObjectMetadata metadata = new ObjectMetadata();
        	metadata.addUserMetadata("fullname", "Alb Ein");
        	metadata.setContentType("image/jpg");
        	//metadata.setContentLength(inputStream.);
        	PutObjectRequest request = new PutObjectRequest(bucketName, fileObjKeyName, inputStream, metadata);
            PutObjectResult por=s3Client.putObject(request);
        } catch (AmazonServiceException e) {
            // The call was transmitted successfully, but Amazon S3 couldn't process 
            // it, so it returned an error response.
            e.printStackTrace();
        } catch (SdkClientException e) {
            // Amazon S3 couldn't be contacted for a response, or the client
            // couldn't parse the response from Amazon S3.
            e.printStackTrace();
        }
    }*/

	public String uploadUserDetails(InputStream fileInput, String fullName, String fileName) {
		Regions clientRegion = Regions.DEFAULT_REGION;
        String bucketName = "imageuploadandprocessings3bucket";
        String fileObjKeyName = "index/"+fileName;
        String response="Failed";
        try {
        	AmazonS3 s3Client=AmazonS3ClientBuilder.defaultClient();
        	ObjectMetadata metadata = new ObjectMetadata();
        	metadata.addUserMetadata("fullname", fullName);
        	metadata.setContentType("image/jpg");
        	//metadata.setContentLength(inputStream.);
        	PutObjectRequest request = new PutObjectRequest(bucketName, fileObjKeyName, fileInput, metadata);
            PutObjectResult por=s3Client.putObject(request);
            if(por!=null) {
            	System.out.println("Success");
            	response="Success";
            }
        } catch (AmazonServiceException e) {
            // The call was transmitted successfully, but Amazon S3 couldn't process 
            // it, so it returned an error response.
            e.printStackTrace();
        } catch (SdkClientException e) {
            // Amazon S3 couldn't be contacted for a response, or the client
            // couldn't parse the response from Amazon S3.
            e.printStackTrace();
        }
        
		return response;
	}
}
