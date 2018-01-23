package dataProviders;
	import java.io.BufferedReader;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.Arrays;
	import java.util.List;
	import com.google.gson.Gson;
	import managers.FileReaderManager;
	import testDataTypes.Account;;
	
public class JsonDataReader {
	private final String accountFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath() + "Account.json";
	private List<Account> accountList;
	
	public JsonDataReader(){
		accountList = getAccountData();
	}
	
	private List<Account> getAccountData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(accountFilePath));
			Account[] accounts = gson.fromJson(bufferReader, Account[].class);
			return Arrays.asList(accounts);
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + accountFilePath);
		}finally {
			try { if(bufferReader != null) bufferReader.close();}
			catch (IOException ignore) {}
		}
	}
		
	public final Account getAccountByEmail(String accountEmail){
		for(Account account : accountList) {
			if(account.email.equalsIgnoreCase(accountEmail)) return account;
		}
		return null;
	}
	

}