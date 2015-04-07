package controllers;



import models.Gem;
import models.GemList;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class GemController extends Controller {

	
	/*
	 *  @BodyParser.Of(BodyParser.Json.class) at the top of the method.
	 *   Remember that the storePerson method will be called in response to a POST method.
	 *    The data for a new Person object is going to arrive as a JSON string inside 
	 *    the payload of the POST message. The BodyParser annotation is  a handy way that help 
	 *    us parse this payload and convert  it into a JsonNode object, the latter provided
	 *     by the Jackson Library. This class gets imported by the following 
	 *     import in the PersonController class :
import com.fasterxml.jackson.databind.JsonNode;
	 */

	@BodyParser.Of(BodyParser.Json.class)
	public static Result storeGem(){
		ObjectMapper mapper = new ObjectMapper();
		 try {
			 System.err.println("POST Data");
			 JsonNode json = request().body().asJson();
			 System.err.println("json payload: " + json);
			 Gem newGem = mapper.readValue(json.toString(), Gem.class);
			 GemList theList = GemList.getInstance(); 
			 newGem = theList.addGem(newGem);
			 ObjectNode result = Json.newObject();
			 result.set("Gem", Json.toJson(newGem));
			 return created(result);
		 }
		 catch(Exception e){
			 e.printStackTrace();
			 return badRequest("Missing information");
		 }
		
	}
	
	
	public static Result getGem(Long id){
		// DEBUG 
		System.err.println("GET on id: "+ id);
		
		ObjectNode result = Json.newObject();
		GemList theList = GemList.getInstance();
		Gem gem = theList.getGemById(id);
		if (gem == null){
			return notFound(); // 404
		}
		else {
			result.set("Gem", Json.toJson(gem));
			return ok(result);
	
		}
	}
	

	
	@BodyParser.Of(BodyParser.Json.class)
	public static Result updateGem(Long id){
		ObjectMapper mapper = new ObjectMapper();
		try {
 
			 JsonNode json = request().body().asJson();
			 Gem updGem = mapper.readValue(json.toString(), Gem.class);
			 GemList theList = GemList.getInstance(); 
			 updGem = theList.updateGem(updGem);
			 if (updGem == null){
				return notFound(); // 404 
			 }
			 else {
				 ObjectNode result = Json.newObject();
				 result.set("Gem", Json.toJson(updGem));
				 return ok(result);
			 }
		}
		catch(Exception e){
			 e.printStackTrace();
			 return badRequest("Missing information");			
		}
	}
	
		public static Result deleteGem(Long id){
			GemList theList = GemList.getInstance();
			boolean erased = theList.deleteGem(id);
			if (erased){
				// This is code 204 - OK with no content to return
				return noContent();
			}
			else {
				return notFound("Person not found");
			}
	 
		}
	
}
