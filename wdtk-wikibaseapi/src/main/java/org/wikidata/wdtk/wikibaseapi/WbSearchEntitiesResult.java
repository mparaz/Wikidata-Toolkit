package org.wikidata.wdtk.wikibaseapi;

/*
 * #%L
 * Wikidata Toolkit Wikibase API
 * %%
 * Copyright (C) 2014 - 2016 Wikidata Toolkit Developers
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Value class representing the result of a wbsearchentities action.
 *
 * @author Sören Brunk
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WbSearchEntitiesResult {
	
	/**
	 * Class representing information about how a document matched the query
	 */
	public static class Match  {
		
		public Match() {}
		
		public Match(String type, String language, String text) {
			this.type = type;
			this.language = language;
			this.text = text;
		}
		/**
		 * The type (field) of the matching term
		 * e.g "entityId", "label" or "alias"
		 */
		@JsonProperty("type")
		protected String type = "";
		/**
		 * Language of the matching term field
		 */
		@JsonProperty("language")
		protected String language = "";
		/**
		 * Text of the matching term
		 */
		@JsonProperty("text")
		protected String text = "";
		
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getLanguage() {
			return language;
		}
		public void setLanguage(String language) {
			this.language = language;
		}
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((language == null) ? 0 : language.hashCode());
			result = prime * result + ((text == null) ? 0 : text.hashCode());
			result = prime * result + ((type == null) ? 0 : type.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Match other = (Match) obj;
			if (language == null) {
				if (other.language != null)
					return false;
			} else if (!language.equals(other.language))
				return false;
			if (text == null) {
				if (other.text != null)
					return false;
			} else if (!text.equals(other.text))
				return false;
			if (type == null) {
				if (other.type != null)
					return false;
			} else if (!type.equals(other.type))
				return false;
			return true;
		}
	}
	
	/**
	 * Constructor. Creates an empty object that can be populated during JSON
	 * deserialization. Should only be used by Jackson for this very purpose.
	 */
	public WbSearchEntitiesResult() {
	}
	
	/**
	 * The id of the entity that the document refers to.
	 */
	@JsonProperty("id")
	protected String entityId = "";
	
	/** 
	 * The full concept URI (the site IRI with entity ID) 
	 */
	@JsonProperty("concepturi")
	protected String conceptUri = "";
	
	/** 
	 * The URL of the wiki site that shows the concept
	 */
	@JsonProperty("url")
	protected String url = "";
	
	/**
	 * Title of the entity (currently is the same as the entity ID)
	 */
	@JsonProperty("title")
	protected String title = "";
	
	/**
	 * The internal Mediawiki pageid of the entity
	 */
	@JsonProperty("pageid")
	protected long pageId = 0;
	
	/**
	 * Label of the entity
	 * 
	 * The language of the returned label depends on the HTTP
	 * <a href="https://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.4">
	 * Accept-Language header or the uselang URL parameter.
	 */
	@JsonProperty("label")
	protected String label = "";
	
	/**
	 * Description of the entity
	 * 
	 * The language of the returned description depends on the HTTP
	 * <a href="https://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.4">
	 * Accept-Language header or the uselang URL parameter.
	 */
	@JsonProperty("description")
	protected String description = "";
	
	/**
	 * Detailed information about how a document matched the query
	 */
	@JsonProperty("match")
	protected Match match;
	
	/**
	 * A list of alias labels (returned only when an alias matched the query)
	 */
	@JsonProperty("aliases")
	protected List<String> aliases;
	
	public void setEntityId(String id) {
		this.entityId = id;
	}

	public String getEntityId() {
		return this.entityId;
	}

	public String getConceptUri() {
		return conceptUri;
	}

	public void setConceptUri(String conceptUri) {
		this.conceptUri = conceptUri;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getPageId() {
		return pageId;
	}

	public void setPageId(long pageId) {
		this.pageId = pageId;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Match getMatch() {
		return match;
	}

	
	public void setMatch(Match match) {
		this.match = match;
	}

	public List<String> getAliases() {
		return aliases;
	}

	public void setAliases(List<String> aliases) {
		this.aliases = aliases;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aliases == null) ? 0 : aliases.hashCode());
		result = prime * result
				+ ((conceptUri == null) ? 0 : conceptUri.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((entityId == null) ? 0 : entityId.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((match == null) ? 0 : match.hashCode());
		result = prime * result + (int) (pageId ^ (pageId >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WbSearchEntitiesResult other = (WbSearchEntitiesResult) obj;
		if (aliases == null) {
			if (other.aliases != null)
				return false;
		} else if (!aliases.equals(other.aliases))
			return false;
		if (conceptUri == null) {
			if (other.conceptUri != null)
				return false;
		} else if (!conceptUri.equals(other.conceptUri))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (entityId == null) {
			if (other.entityId != null)
				return false;
		} else if (!entityId.equals(other.entityId))
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (match == null) {
			if (other.match != null)
				return false;
		} else if (!match.equals(other.match))
			return false;
		if (pageId != other.pageId)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}


}
