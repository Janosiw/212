public class Test {
    public static void main(String[] args) {

        // Welcome Message
        System.out.println("\n****************************************");
        System.out.println("*  Welcome to Photo Manager (BST)   *");
        System.out.println("****************************************\n");

        InvIndexPhotoManager invmanager = new InvIndexPhotoManager();

        // Adding Photos
        Photo photo1 = new Photo("hedgehog.jpg", toTagsLinkedList("animal, hedgehog, apple, grass, green"));
        Photo photo2 = new Photo("bear.jpg", toTagsLinkedList("animal, bear, cab, grass, wind"));
        Photo photo3 = new Photo("orange-butterfly.jpg", toTagsLinkedList("insect, butterfly, flower, color"));

        invmanager.addPhoto(photo1);
        invmanager.addPhoto(photo2);
        invmanager.addPhoto(photo3);

        // List all added photos
      // List all added photos
System.out.println("\n***** List of all added Photos *****");
System.out.println(photo1.getPath());
System.out.println(photo2.getPath());
System.out.println(photo3.getPath());


        Album album1 = new Album("Album1", "bear", null, invmanager);
        Album album2 = new Album("Album2", "animal AND grass", null, invmanager);
        Album album3 = new Album("Album3", "", null, invmanager);

        // Display Photo1 path and tags
        System.out.println("\n***** Get photo1 path and tags *****");
        System.out.println("photo1 path: " + photo1.getPath());
        printLL(photo1.getTags());

        // Album 1 (using BST)
        System.out.println("\n***** Get album1 name, condition, and photos (BST) *****");
        System.out.println("album1 name: " + album1.getName());
        System.out.println("album1 condition: " + album1.getCondition());
        System.out.println();
        LinkedList<Photo> photos1 = album1.getPhotosBSTOnly();
        int comps1 = album1.getNbComps();
        printLLPhoto(photos1);
        System.out.printf("Number of comparisons of condition \"%s\" is %d\n", album1.getCondition(), comps1);

        // Album 2 (using BST)
        System.out.println("\n***** Get album2 name, condition, and photos (BST) *****");
        System.out.println("album2 name: " + album2.getName());
        System.out.println("album2 condition: " + album2.getCondition());
        System.out.println();
        LinkedList<Photo> photos2 = album2.getPhotosBSTOnly();
        int comps2 = album2.getNbComps();
        printLLPhoto(photos2);
        System.out.printf("Number of comparisons of condition \"%s\" is %d\n", album2.getCondition(), comps2);

        // Album 3 (using BST)
        System.out.println("\n***** Get album3 name, condition, and photos (BST) *****");
        System.out.println("album3 name: " + album3.getName());
        System.out.println("album3 condition: " + album3.getCondition());
        System.out.println();
        LinkedList<Photo> photos3 = album3.getPhotosBSTOnly();
        int comps3 = album3.getNbComps();
        printLLPhoto(photos3);
        System.out.printf("Number of comparisons of condition \"%s\" is %d\n", album3.getCondition(), comps3);

        // Deleting Photo bear.jpg
        System.out.println("\n***** Deleting the photo 'bear.jpg' *****");
        invmanager.deletePhoto("bear.jpg");

        // Album 3 after deletion (using BST)
        System.out.println("\n***** Get album3 name, condition, and photos (After Deletion) (BST) *****");
        System.out.println("album3 name: " + album3.getName());
        System.out.println("album3 condition: " + album3.getCondition());
        System.out.println();
        LinkedList<Photo> photosAfterDeletion = album3.getPhotosBSTOnly();
        int compsAfterDeletion = album3.getNbComps();
        printLLPhoto(photosAfterDeletion);
        System.out.printf("Number of comparisons of condition \"%s\" is %d\n", album3.getCondition(), compsAfterDeletion);

        // Goodbye Message
        System.out.println("\n****************************************");
        System.out.println("*        Thank you for using us!       *");
        System.out.println("****************************************\n");
    }

    // يحول ستـرنق يحتوي على كلمات مفصولة بفواصل إلى LinkedList تاقات.


    private static LinkedList<String> toTagsLinkedList(String tags) {
        LinkedList<String> result = new LinkedList<String>();
        String[] tagsArray = tags.split("\\s*,\\s*");
        for (String tag : tagsArray) {
            result.insert(tag);
        }
        return result;
    }
//طبع كل مسارات الصور اللي داخل LinkedList.
    private static void printLL(LinkedList<String> list) {
        list.findFirst();
        if (list.empty())
            return;
        while (true) {
            System.out.print(list.retrieve() + " ");
            if (list.last())
                return;
            list.findNext();
        }
    }

    private static void printLLPhoto(LinkedList<Photo> list) {
        list.findFirst();
        if (list.empty())
            return;
        while (true) {
            System.out.println(list.retrieve().getPath());
            if (list.last())
                return;
            list.findNext();
        }
    }
}

