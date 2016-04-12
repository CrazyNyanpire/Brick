package acetecsemi.com.brick.facade.impl.assembler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import acetecsemi.com.brick.facade.dto.*;
import acetecsemi.com.brick.core.domain.*;

public class SwiftNumberAssembler {
	
	public static SwiftNumberDTO  toDTO(SwiftNumber  swiftNumber){
		if (swiftNumber == null) {
			return null;
		}
    	SwiftNumberDTO result  = new SwiftNumberDTO();
	    	result.setId (swiftNumber.getId());
     	    	result.setVersion (swiftNumber.getVersion());
     	    	result.setCreateTimestamp (swiftNumber.getCreateTimestamp());
     	    	result.setLastModifyTimestamp (swiftNumber.getLastModifyTimestamp());
     	    	result.setCreateEmployNo (swiftNumber.getCreateEmployNo());
     	    	result.setLastModifyEmployNo (swiftNumber.getLastModifyEmployNo());
     	    	result.setType (swiftNumber.getType());
     	    	result.setStartTitle (swiftNumber.getStartTitle());
     	    	result.setDate (swiftNumber.getDate());
     	    	result.setSn (swiftNumber.getSn());
     	    	result.setTotalSn (swiftNumber.getTotalSn());
     	    	result.setNowSwiftNumber (swiftNumber.getNowSwiftNumber());
     	    return result;
	 }
	
	public static List<SwiftNumberDTO>  toDTOs(Collection<SwiftNumber>  swiftNumbers){
		if (swiftNumbers == null) {
			return null;
		}
		List<SwiftNumberDTO> results = new ArrayList<SwiftNumberDTO>();
		for (SwiftNumber each : swiftNumbers) {
			results.add(toDTO(each));
		}
		return results;
	}
	
	 public static SwiftNumber  toEntity(SwiftNumberDTO  swiftNumberDTO){
	 	if (swiftNumberDTO == null) {
			return null;
		}
	 	SwiftNumber result  = new SwiftNumber();
        result.setId (swiftNumberDTO.getId());
         result.setVersion (swiftNumberDTO.getVersion());
         result.setCreateTimestamp (swiftNumberDTO.getCreateTimestamp());
         result.setLastModifyTimestamp (swiftNumberDTO.getLastModifyTimestamp());
         result.setCreateEmployNo (swiftNumberDTO.getCreateEmployNo());
         result.setLastModifyEmployNo (swiftNumberDTO.getLastModifyEmployNo());
         result.setType (swiftNumberDTO.getType());
         result.setStartTitle (swiftNumberDTO.getStartTitle());
         result.setDate (swiftNumberDTO.getDate());
         result.setSn (swiftNumberDTO.getSn());
         result.setTotalSn (swiftNumberDTO.getTotalSn());
         result.setNowSwiftNumber (swiftNumberDTO.getNowSwiftNumber());
 	  	return result;
	 }
	
	public static List<SwiftNumber> toEntities(Collection<SwiftNumberDTO> swiftNumberDTOs) {
		if (swiftNumberDTOs == null) {
			return null;
		}
		
		List<SwiftNumber> results = new ArrayList<SwiftNumber>();
		for (SwiftNumberDTO each : swiftNumberDTOs) {
			results.add(toEntity(each));
		}
		return results;
	}
}
