package com.mcakir.core.config;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.cfg.DefaultComponentSafeNamingStrategy;

public class NamingStrategy extends DefaultComponentSafeNamingStrategy{
	
	private static final long serialVersionUID = 1L;

	@Override
	public String propertyToColumnName(String propertyName) {
		
		return addUnderscoresForSplit(propertyName);
		
	}
	
	@Override
	public String foreignKeyColumnName(
			String propertyName, String propertyEntityName, String propertyTableName, String referencedColumnName) {
		
		String header = propertyName != null ? addUnderscoresForSplit( propertyName ) : addUnderscoresForSplit(propertyTableName);
		
		return columnName( header + "_" + referencedColumnName );
	}
	
	@Override
	public String classToTableName(String className){
		
		return addUnderscoresForSplit(className);
		
	}
	
	@Override
	public String collectionTableName(String ownerEntity, String ownerEntityTable, 
			String associatedEntity, String associatedEntityTable, String propertyName) {
		
		return tableName(
				new StringBuilder( addUnderscoresForSplit(ownerEntityTable) ).append( "_" ).append(
				associatedEntityTable != null ? addUnderscoresForSplit(associatedEntityTable) : addUnderscoresForSplit( propertyName )).toString());
		
	}
	
	@Override
	public String logicalCollectionTableName(
			String tableName, String ownerEntityTable, String associatedEntityTable, String propertyName
	) {
		
		if ( tableName != null ) {
			return tableName;
		}
		else {
			
			return tableName(
				new StringBuilder( addUnderscoresForSplit(ownerEntityTable) ).append( "_" ).append(
				associatedEntityTable != null ? addUnderscoresForSplit(associatedEntityTable) : addUnderscoresForSplit( propertyName )).toString());
			
		}
		
	}
	
	
	private String addUnderscoresForSplit(String value){
		
		List<Integer> indexs = findUpperCaseIndexs(value);
		
		String name = addUnderscores( value );
		
		if(indexs.size() > 0){
			
			StringBuilder builder = new StringBuilder(name);
			int shift = 0;
			
			for(int index : indexs){
				builder.insert(index + shift, "_");
				shift++;
			}
		
			return builder.toString();
			
		}
		
		return name;
		
	}
	
	private List<Integer> findUpperCaseIndexs(String value){
		
		List<Integer> indexs = new ArrayList<Integer>();
		
		if(value != null && value.length() > 0){
			
			for(int i=1;i<value.length();i++){
				if(Character.isUpperCase(value.charAt(i)))
					indexs.add(i);
			}
			
		}
		
		return indexs;
		
	}
	
}
