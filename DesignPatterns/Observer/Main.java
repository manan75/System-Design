package DesignPatterns.Observer;

public class Main {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();

        Observer channel1 = new NewsChannel("NDTV");
        Observer channel2 = new NewsChannel("BBC");

        agency.attach(channel1);
        agency.attach(channel2);

        agency.breakingNews("India wins the match!");
        agency.breakingNews("New tech product launch!");

        agency.detach(channel1);
        agency.breakingNews("Stock market hits all-time high!");
    }
}
