package com.migo.seo.utils.aws;

import java.io.File;
import java.io.IOException;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import com.amazonaws.services.s3.transfer.Upload;

public class LowLevelMultipartUpload {

 /**
 * @param args
 * @throws IOException
 * 
 * This is the sample code taken from AWS to upload files to S3 looks like something is broken.
 */
public static void main(String[] args) throws IOException {
     String clientRegion = "USWest(Oregon)";
     String bucketName = "migo-seo-image";
     String keyName = "test";
     String filePath = "/Users/chintald/Desktop/image1.png";
         try {
             AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                     .withRegion(clientRegion)
                     .withCredentials(new ProfileCredentialsProvider())
                     .build();
             TransferManager tm = TransferManagerBuilder.standard()
                     .withS3Client(s3Client)
                     .build();
             
             // TransferManager processes all transfers asynchronously,
             // so this call returns immediately.
             Upload upload = tm.upload(bucketName, keyName, new File(filePath));
             System.out.println("Object upload started");
     
             // Optionally, wait for the upload to finish before continuing.
             upload.waitForCompletion();
             System.out.println("Object upload complete");
         }
         catch(AmazonServiceException e) {
             // The call was transmitted successfully, but Amazon S3 couldn't process 
             // it, so it returned an error response.
             e.printStackTrace();
         }
         catch(SdkClientException e) {
             // Amazon S3 couldn't be contacted for a response, or the client
             // couldn't parse the response from Amazon S3.
             e.printStackTrace();
         } catch (AmazonClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }
}