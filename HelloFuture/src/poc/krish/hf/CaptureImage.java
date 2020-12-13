package poc.krish.hf;

import java.io.InputStream;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;

public class CaptureImage {

	public String uploadUserDetails(InputStream fileInput, String fullName, String fileName) {
		Regions clientRegion = Regions.DEFAULT_REGION;
		String bucketName = "imageuploadandprocessings3bucket";
		String fileObjKeyName = "index/" + fileName;
		String response = "Registration Failed";
		try {
			// AmazonS3 s3Client=AmazonS3ClientBuilder.defaultClient();
			AmazonS3 s3Client = AmazonS3ClientBuilder.standard().build();
			ObjectMetadata metadata = new ObjectMetadata();
			metadata.addUserMetadata("fullname", fullName);
			metadata.setContentType("image/jpg");
			// metadata.setContentLength(inputStream.);
			PutObjectRequest request = new PutObjectRequest(bucketName, fileObjKeyName, fileInput, metadata);
			PutObjectResult por = s3Client.putObject(request);
			if (por != null) {
				System.out.println("Success");
				response = "Registration Successful";
			}
		} catch (AmazonServiceException e) {
			return null;
		} catch (SdkClientException e) {
			return null;
		}

		return response;
	}
}
