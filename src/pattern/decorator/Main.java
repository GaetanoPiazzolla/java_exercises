package pattern.decorator;

// soluzione per evitare l'ereditarietà 
// e per aggiungere in maniera separata un decorator dall'altro IN MANIERA INCREMENTALE
// aggiunge responsabilita' all'interfaccia a RUN TIME

public class Main {

	// The Window interface class
	public interface Window {
		void draw(); // Draws the Window

		String getDescription(); // Returns a description of the Window
	}

	// Implementation of a simple Window without any scrollbars
	public class SimpleWindow implements Window {
		public void draw() {
			// Draw window
		}

		public String getDescription() {
			return "simple window";
		}
	}

	// Implementation of a complex Window without any scrollbars
	public class ComplexWindow implements Window {
		public void draw() {
			// Draw window
		}

		public String getDescription() {
			return "complex window";
		}
	}

	// abstract decorator class - note that it implements Window
	public abstract class WindowDecorator implements Window {
		protected Window windowToBeDecorated; // the Window being decorated

		public WindowDecorator(Window windowToBeDecorated) {
			this.windowToBeDecorated = windowToBeDecorated;
		}

		public void draw() {
			windowToBeDecorated.draw(); // Delegation
		}

		public String getDescription() {
			return windowToBeDecorated.getDescription(); // Delegation
		}
	}

	// The first concrete decorator which adds vertical scrollbar functionality
	public class VerticalScrollBarDecorator extends WindowDecorator {
		public VerticalScrollBarDecorator(Window windowToBeDecorated) {
			super(windowToBeDecorated);
		}

		@Override
		public void draw() {
			super.draw();
			drawVerticalScrollBar();
		}

		private void drawVerticalScrollBar() {
			// Draw the vertical scrollbar
		}

		@Override
		public String getDescription() {
			return super.getDescription() + ", including vertical scrollbars";
		}
	}

	// The second concrete decorator which adds horizontal scrollbar
	// functionality
	public class HorizontalScrollBarDecorator extends WindowDecorator {
		public HorizontalScrollBarDecorator(Window windowToBeDecorated) {
			super(windowToBeDecorated);
		}

		@Override
		public void draw() {
			super.draw();
			drawHorizontalScrollBar();
		}

		private void drawHorizontalScrollBar() {
			// Draw the horizontal scrollbar
		}

		@Override
		public String getDescription() {
			return super.getDescription() + ", including horizontal scrollbars";
		}
	}

	public static void main(String[] args) {
		// Create a decorated Window with horizontal and vertical scrollbars

		Main m = new Main();
		Window decoratedWindow = m.new HorizontalScrollBarDecorator(
				m.new VerticalScrollBarDecorator(m.new SimpleWindow()));

		Window decoratedWindow2 = m.new VerticalScrollBarDecorator(decoratedWindow);

		// Print the Window's description
		System.out.println(decoratedWindow.getDescription());
		System.out.println(decoratedWindow2.getDescription());
	}

}