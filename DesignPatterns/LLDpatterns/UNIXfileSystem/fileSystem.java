package DesignPatterns.LLDpatterns.UNIXfileSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class fileSystem {

    Directory root;
    Directory currentDirectory;
    //instantiate the root and currDir
    public fileSystem() {
        root = new Directory("", null);
        currentDirectory = root;
    }
    //creates the token and makes the directory
    public void mkdir(String path) {
        List<String> tokens = getTokens(path);
        mkdirHelper(root, tokens, 0);
    }
    //uses resolvepath fn
    public void cd(String path){
        currentDirectory = resolvePath(path);
    }
    //travels upwards towards the parents until it reaches parent and then reverses the path with /
  public String pwd() {
        List<String> parts = new ArrayList<>();
        Directory curr = currentDirectory;
        while (curr != null) {
            if (!curr.getName().isEmpty()) {
                parts.add(curr.getName());
            }
            curr = curr.getParent();
        }
        Collections.reverse(parts);
        return "/" + String.join("/", parts);
    }
    //for wild card we check all the children of current dir and perform a dfs to find the first match
    public Directory wildcardDFS(Directory curr,List<String> tokens,int index) {
            if (index == tokens.size()) {
                return curr;
            }
            String token = tokens.get(index);
            if (token.equals("*")) {
                for (Directory child : curr.getChildren().values()) {
                    Directory result =
                            wildcardDFS(child, tokens, index + 1);

                    if (result != null) {
                        return result;
                    }
                }
                return null;
            }
            Directory child = curr.getChildren().get(token);
            if (child == null) {
                return null;
            }
            return wildcardDFS(child, tokens, index + 1);
    }

    //for absolute path we start from root, else from current root
    private  Directory resolvePath(String path) {
        Directory dir ;
        if(path.startsWith("/")){
            dir = root;
        }
        else{
            dir = currentDirectory;
        }
        List<String> tokens = getTokens(path);
        for (String t : tokens) {
            if(t.equals("..")){
                 if(dir.getParent() != null){
                     dir = dir.getParent();
                    }
            }
            else if(t.equals(".")){
                continue;
            }
            else{
                 Directory child = dir.getChildren().get(t);
                if (child == null) {
                    throw new RuntimeException(
                            "Path does not exist: " + path);
                }
                dir = child;
            }
           
        }
        return dir;
    }
    //splits the path on / and returns the directories as tokens
    private List<String> getTokens(String path) {
        List<String> tokens = new ArrayList<>();
        for (String token : path.split("/")) {
            if (!token.isEmpty()) {
                tokens.add(token);
            }
        }
        return tokens;
    }
    //recursively travel to path if path not there first make it and then go to child
    private void mkdirHelper(Directory curr, List<String> tokens, int index) {
        if (index == tokens.size()) {
            return;
        }
        String dirName = tokens.get(index);
        Directory child = curr.getChildren().get(dirName);
        if (child == null) {
            //important first make the child and then add it to the curr (parent)
            child = new Directory(dirName, curr);
            curr.getChildren().put(dirName, child);
        }
        //and then recurse on the child
        mkdirHelper(child, tokens, index + 1);
    }

}
