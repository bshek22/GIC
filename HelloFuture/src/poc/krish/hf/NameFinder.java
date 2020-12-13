package poc.krish.hf;

import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;

public class NameFinder {
	public static final String tableName = "facialmatadatatable";
	public static final String primaryKey = "RekognitionId";
	public static final String attrName = "FullName";

	public String lookupName(String faceId) {
		// AmazonDynamoDB client = AmazonDynamoDBClientBuilder.defaultClient();
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();

		DynamoDB dynamoDB = new DynamoDB(client);

		Table table = dynamoDB.getTable(tableName);

		GetItemSpec spec = new GetItemSpec().withPrimaryKey(primaryKey, faceId);

		String result = null;

		try {
			Item outcome = table.getItem(spec);
			result = outcome.getString(attrName);
		} catch (Exception e) {
			System.err.println("Unable to read item: " + faceId);
			System.err.println(e.getMessage());
		}

		return result;

	}

}
