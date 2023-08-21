package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> votesPerCandidate = new HashMap<>();

        System.out.print("Enter file full path: ");
        String path = sc.nextLine();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();

            while(line != null){
                String[] fields = line.split(",");
                String name = fields[0];
                Integer votes = Integer.parseInt(fields[1]);

                if(votesPerCandidate.containsKey(name)){
                    int votesSoFar = votesPerCandidate.get(name);
                    votesPerCandidate.put(name, votes + votesSoFar);
                } else{
                    votesPerCandidate.put(name, votes);
                }

                line = br.readLine();
            }

            for(var entry : votesPerCandidate.entrySet()){
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}