package poc.krish.hf;

import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.amazonaws.services.rekognition.model.DeleteFacesRequest;
import com.amazonaws.services.rekognition.model.DeleteFacesResult;

import java.util.List;


public class DeleteFacesFromCollection {
   public static final String collectionId = "face_recognition_collection";
   public static final String faces[] = {"7c2d9dbc-8181-486d-81f7-b9c188c0fe1c"};

   public static void main(String[] args) throws Exception {
      
      AmazonRekognition rekognitionClient = AmazonRekognitionClientBuilder.defaultClient();
     
      
      DeleteFacesRequest deleteFacesRequest = new DeleteFacesRequest()
              .withCollectionId(collectionId)
              .withFaceIds(faces);
     
      DeleteFacesResult deleteFacesResult=rekognitionClient.deleteFaces(deleteFacesRequest);
      
     
      List < String > faceRecords = deleteFacesResult.getDeletedFaces();
      System.out.println(Integer.toString(faceRecords.size()) + " face(s) deleted:");
      for (String face: faceRecords) {
         System.out.println("FaceID: " + face);
      }
   }
}