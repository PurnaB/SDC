package in.apssdc.controller;

import in.apssdc.model.FileModel;

import java.io.FileOutputStream;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.andromeda.commons.model.Response;
import commons.util.Base64;

@RestController
@RequestMapping("/file")
public class FileUploadController
{

	Response response = new Response();

	@ResponseBody
	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public Response handleFileUpload(@RequestBody FileModel fileModel)
	{
		response.setSuccessful(false);
		try
		{
			System.out.println("Downloading File From: " + fileModel.getFileName());
			byte[] imageByteArray = decodeImage(fileModel.getBase64String());
			FileOutputStream imageOutFile =
					new FileOutputStream("D:/upload/" + fileModel.getFileName());
			imageOutFile.write(imageByteArray);
		}
		catch (Exception e)
		{
			System.out.println("Exception: " + e.getMessage());
		}
		response.setSuccessful(true);
		response.setResponseObject(fileModel);
		return response;
	}

	public static byte[] decodeImage(String imageValue)
	{
		return Base64.decode(imageValue);
	}
}
