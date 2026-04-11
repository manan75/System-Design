package DesignPatterns.Composite;

public class Human {
    public static void main(String[] args) {
        Component heart = new Organs("Heart");
        Component brain = new Organs("Brain");
        Component spine = new Organs("Spinal Cord");
        Component stomach = new Organs("Stomach");
        Component pancreas = new Organs("Pancreas");
        Component intestine = new Organs("Intestine");
        Component liver = new Organs("Liver");
        Component eyes = new Organs("Eyes");
        Component ear = new Organs("Ears");
        Component tongue = new Organs("Tongue");
   ;
        

        OrganSystem cardiovascularSystem = new OrganSystem("Cardiovascular System");
        OrganSystem nervouSystem = new OrganSystem("Nervous System");
        OrganSystem digestiveSystem= new OrganSystem("Digestive System");
        OrganSystem  sensoryOrganSystem = new OrganSystem("Sensory Organ System");
        

        cardiovascularSystem.addOrgan(heart);

        nervouSystem.addOrgan(brain);
        nervouSystem.addOrgan(spine);

        digestiveSystem.addOrgan(stomach);
        digestiveSystem.addOrgan(pancreas);
        digestiveSystem.addOrgan(intestine);
        digestiveSystem.addOrgan(liver);

        sensoryOrganSystem.addOrgan(ear);
        sensoryOrganSystem.addOrgan(eyes);
        sensoryOrganSystem.addOrgan(tongue);


        cardiovascularSystem.showName();
        nervouSystem.showName();
        digestiveSystem.showName();
        sensoryOrganSystem.showName();
    


    }
}
