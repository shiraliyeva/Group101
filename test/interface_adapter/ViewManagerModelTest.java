package interface_adapter;

import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static org.junit.jupiter.api.Assertions.*;

class ViewManagerModelTest {

    @Test
    void testSetAndGetActiveView() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();

        assertNull(viewManagerModel.getActiveView(), "Initially, active view should be null");

        viewManagerModel.setActiveView("TestView");

        assertEquals("TestView", viewManagerModel.getActiveView(), "Active view should be set to TestView");
    }

    @Test
    void testFirePropertyChanged() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TestPropertyChangeListener testListener = new TestPropertyChangeListener();
        viewManagerModel.addPropertyChangeListener(testListener);

        assertNull(testListener.getLastPropertyName(), "Initially, last property name should be null");

        viewManagerModel.setActiveView("TestView");
        viewManagerModel.firePropertyChanged();

        assertEquals("view", testListener.getLastPropertyName(), "Property name should be 'view'");
        assertNull(testListener.getOldValue(), "Old value should be null");
        assertEquals("TestView", testListener.getNewValue(), "New value should be 'TestView'");
    }

    private static class TestPropertyChangeListener implements PropertyChangeListener {
        private String lastPropertyName;
        private Object oldValue;
        private Object newValue;

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            lastPropertyName = evt.getPropertyName();
            oldValue = evt.getOldValue();
            newValue = evt.getNewValue();
        }

        public String getLastPropertyName() {
            return lastPropertyName;
        }

        public Object getOldValue() {
            return oldValue;
        }

        public Object getNewValue() {
            return newValue;
        }
    }

}
