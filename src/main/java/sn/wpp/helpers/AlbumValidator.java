package sn.wpp.helpers;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public class AlbumValidator
{
	private String TITRE;
	private String DESCRIPTION;
	private HttpServletRequest request;
	public HashMap<String, String> result = new HashMap<String, String>();
	private final String STR_PATTERN = "[A-Za-z������]{2,}";
	
	public AlbumValidator(HttpServletRequest request)
	{
		this.request = request;
		this.TITRE = this.request.getParameter("titre") == null ? "" : this.request.getParameter("titre");
		this.DESCRIPTION = this.request.getParameter("description") == null ? ""
				: this.request.getParameter("description");
	}
	
	public HashMap<String, String> validate()
	{
		if (this.isEmptyForm())
		{
			this.result.put("vide", "Veuillez remplir tous les champs");
		}
		if (!this.isValidTitle())
		{
			this.result.put("titre", "Le titre doit comporter au minimum deux (2) caract�res.");
		}
		if (!this.isValidDescription())
		{
			this.result.put("description", "La description doit comporter au minimum deux (2) caract�res.");
		}
		return this.result;
	}
	
	private boolean isValidTitle()
	{
		return this.removeSpaces(TITRE.trim()).matches(STR_PATTERN);
	}
	
	private boolean isValidDescription()
	{
		return this.removeSpaces(DESCRIPTION.trim()).matches(STR_PATTERN);
	}
	
	private boolean isEmptyForm()
	{
		if (this.TITRE.isEmpty() || this.DESCRIPTION.isEmpty())
		{
			return true;
		}
		return false;
	}
	
	private String removeSpaces(String in)
	{
		return in.replaceAll(" ", "");
	}
	
}
