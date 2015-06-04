package fixed2free;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * This class serves as a symbol table for RPG code
 * RPG does not have any anonymous scopes nor nested local scopes so the design of this 
 * symbol table is much more simple than one for Java or C++
 * @author Eric Wilson
 *
 */
public class SymbolTable {
	private Map<String, Scope>scopes = new HashMap<String, Scope>();
	private Map<Scope, Map<String, Symbol>>symbolTable = new HashMap<Scope, Map<String, Symbol>>();

	/**
	 * Get a scope instance for a given scope identifier
	 * The Global scope should us the Scope.GLOBAL constant as it's identifier
	 * Side effect:
	 * If the scope does not exist then one will be created and that will be returned
	 * @param scopeIdentifier
	 * @return 
	 */
	public Scope getAScope(String scopeIdentifier){
		Scope result = null;
		result = scopes.get(scopeIdentifier);
		if (result == null){
			result = new Scope(scopeIdentifier);
			scopes.put(scopeIdentifier, result);
			symbolTable.put(result, new HashMap<String, Symbol>());
		}
		return result;
	}
	public Symbol getSymbolFromScope(Scope aScope, String symbolName){
		Map<String, Symbol> temp = symbolTable.get(aScope);
		Symbol result = temp.get(symbolName);
		return result;
	}
	public void addSymbolToScope(Scope aScope, Symbol aSymbol){
		Map<String, Symbol>temp = symbolTable.get(aScope);
		if (temp == null){
			// throw some sort of exception?
		} else {
			if (temp.containsKey(aSymbol.getName())){
				// Do nothing
			} else {
				temp.put(aSymbol.getName(), aSymbol);
			}
		}
	}
	public List<Symbol> getAllSymbolsFromScope(Scope aScope){
		Map<String, Symbol>temp = symbolTable.get(aScope);
		List<Symbol> result = new ArrayList<Symbol>();
		result.addAll(temp.values());
		return result;
	}
	public List<Scope> getAllScopes() {
		List<Scope> result = new ArrayList<Scope>();
		result.addAll(scopes.values());
		return result;
	}
}
