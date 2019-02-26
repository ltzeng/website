package website.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import website.domain.User;

public class FileDBReader {

    public final String USERS_DB = "mock-db-users";

    
    public List<User> getAllUsers() {
        List<String> fileResults = readDB(USERS_DB);
        return translateToUser(fileResults);
    }

    
    //read file to mock a db
    private List<String> readDB(String dbType){
        File file = new File(dbType);

        List<String> fileResults = new ArrayList<String>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String st;

            while ((st = br.readLine()) != null) { 
                fileResults.add(st);
            }

        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        return fileResults;
    }

    //translate file results to user type
    private List<User> translateToUser(List<String> fileResults) {
        List<User> usersList = new ArrayList<User>();
        for(String str : fileResults) {
            User user = new User();
            String[] nodes = str.split(",");
            user.setFirstName(nodes[0]);
            user.setLastName(nodes[1]);
            user.setAddress(nodes[2]);
            user.setState(nodes[3]);
            user.setCountry(nodes[4]);
            usersList.add(user);
        }
        return usersList;
    }
}
