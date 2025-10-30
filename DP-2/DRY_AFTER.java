package DP-2;

public class DRY_AFTER {
    abstract class Button {
        abstract void onClick();
      }
      
      // Subclass implementing specific behavior
      class SubmitButton extends Button {
        @Override void onClick() {
          System.out.println("Form submitted.");
        }
      }
      
      // Subclass implementing different behavior
      class CancelButton extends Button {
        @Override void onClick() {
          System.out.println("Action canceled.");
        }
      }
      
      public class Main {
       public
        static void main(String[] args) {
          Button submit = new SubmitButton();
          submit.onClick();  // Output: Form submitted.
          Button cancel = new CancelButton();
          cancel.onClick();  // Output: Action canceled.
        }
      }
}
