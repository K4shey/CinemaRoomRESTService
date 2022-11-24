class ChristmasTree {

    private String color;

    public ChristmasTree(String color) {
        this.color = color;
    }

    public void putTreeTopper(String color) {
        ChristmasTree.TreeTopper treeTopper = new ChristmasTree.TreeTopper(color);
        treeTopper.sparkle();
    }

    class TreeTopper {

        private String color;

        public TreeTopper(String color) {
            this.color = color;
        }

        public void sparkle() {
            System.out.println("Sparkling " + color + " tree topper looks stunning with "
                    + ChristmasTree.this.color + " Christmas tree!");

        }
    }
}

// this code should work
class CreateHoliday {

    public static void main(String[] args) {

        ChristmasTree christmasTree = new ChristmasTree("green");
        christmasTree.putTreeTopper("silver");

    }
}