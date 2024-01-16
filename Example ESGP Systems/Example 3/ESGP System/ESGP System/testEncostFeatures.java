
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class testEncostFeatures {

    ConsoleInOut console = new ConsoleInOut();
    FeatureOptionsState featureOptionsState = new FeatureOptionsState(console);

    // TESTING: encostFeatureSelection() method
    // EXPECTED: true is returned
    @Test
    @DisplayName("Testing encostFeatureSelection() for input '1'")
    public void validOptionNumber() {

        // ACT
        Boolean result = featureOptionsState.encostFeatureSelection("1");

        // ASSERT
        Assertions.assertTrue(result);
    }

    // TESTING: encostFeatureSelection() method
    // EXPECTED: true is returned
    @Test
    @DisplayName("Testing encostFeatureSelection() for input '2'")
    public void validOptionNumber2() {

        // ACT
        Boolean result = featureOptionsState.encostFeatureSelection("2");

        // ASSERT
        Assertions.assertTrue(result);
    }

    // TESTING: encostFeatureSelection() method
    // EXPECTED: true is returned
    @Test
    @DisplayName("Testing encostFeatureSelection() for input '3'")
    public void validOptionNumber3() {

        // ACT
        Boolean result = featureOptionsState.encostFeatureSelection("3");

        // ASSERT
        Assertions.assertTrue(result);
    }

    // TESTING: encostFeatureSelection() method
    // EXPECTED: true is returned
    @Test
    @DisplayName("Testing encostFeatureSelection() for input 'load custom dataset'")
    public void validOptionFull() {

        // ACT
        Boolean result = featureOptionsState.encostFeatureSelection("load custom dataset");

        // ASSERT
        Assertions.assertTrue(result);
    }

    // TESTING: encostFeatureSelection() method
    // EXPECTED: true is returned
    @Test
    @DisplayName("Testing encostFeatureSelection() for input 'LOAD CUSTOM DATASET'")
    public void validOptionFullCapital() {

        // ACT
        Boolean result = featureOptionsState.encostFeatureSelection("LOAD CUSTOM DATASET");

        // ASSERT
        Assertions.assertTrue(result);
    }

    // TESTING: encostFeatureSelection() method
    // EXPECTED: true is returned
    @Test
    @DisplayName("Testing encostFeatureSelection() for input 'load'")
    public void validOptionWord() {

        // ACT
        Boolean result = featureOptionsState.encostFeatureSelection("load");

        // ASSERT
        Assertions.assertTrue(result);
    }

    // TESTING: encostFeatureSelection() method
    // EXPECTED: true is returned
    @Test
    @DisplayName("Testing encostFeatureSelection() for input 'data graph visualisation'")
    public void validOptionFull2() {

        // ACT
        Boolean result = featureOptionsState.encostFeatureSelection("data graph visualisation");

        // ASSERT
        Assertions.assertTrue(result);
    }

    // TESTING: encostFeatureSelection() method
    // EXPECTED: true is returned
    @Test
    @DisplayName("Testing encostFeatureSelection() for input 'graph'")
    public void validOptionWord2() {

        // ACT
        Boolean result = featureOptionsState.encostFeatureSelection("graph");

        // ASSERT
        Assertions.assertTrue(result);
    }

    // TESTING: encostFeatureSelection() method
    // EXPECTED: true is returned
    @Test
    @DisplayName("Testing encostFeatureSelection() for input 'view summary statistics'")
    public void validOptionFull3() {

        // ACT
        Boolean result = featureOptionsState.encostFeatureSelection("view summary statistics");

        // ASSERT
        Assertions.assertTrue(result);
    }

    // TESTING: encostFeatureSelection() method
    // EXPECTED: true is returned
    @Test
    @DisplayName("Testing encostFeatureSelection() for input 'summary'")
    public void validOptionWord3() {

        // ACT
        Boolean result = featureOptionsState.encostFeatureSelection("summary");

        // ASSERT
        Assertions.assertTrue(result);
    }

    // TESTING: encostFeatureSelection() method
    // EXPECTED: true is returned
    @Test
    @DisplayName("Testing encostFeatureSelection() for input 'home'")
    public void validHome() {

        // ACT
        Boolean result = featureOptionsState.encostFeatureSelection("home");

        // ASSERT
        Assertions.assertTrue(result);
    }

    // TESTING: encostFeatureSelection() method
    // EXPECTED: true is returned
    @Test
    @DisplayName("Testing encostFeatureSelection() for input 'HOME'")
    public void validHomeCapital() {

        // ACT
        Boolean result = featureOptionsState.encostFeatureSelection("HOME");

        // ASSERT
        Assertions.assertTrue(result);
    }

    // TESTING: encostFeatureSelection() method
    // EXPECTED: true is returned
    @Test
    @DisplayName("Testing encostFeatureSelection() for input 'back'")
    public void validBack() {

        // ACT
        Boolean result = featureOptionsState.encostFeatureSelection("back");

        // ASSERT
        Assertions.assertTrue(result);
    }

    // TESTING: encostFeatureSelection() method
    // EXPECTED: false is returned
    @Test
    @DisplayName("Testing encostFeatureSelection() for input '4'")
    public void invalidOptionNumber() {

        // ACT
        Boolean result = featureOptionsState.encostFeatureSelection("4");

        // ASSERT
        Assertions.assertFalse(result);
    }

    // TESTING: encostFeatureSelection() method
    // EXPECTED: false is returned
    @Test
    @DisplayName("Testing encostFeatureSelection() for input 'load graph'")
    public void invalidOptionWord() {

        // ACT
        Boolean result = featureOptionsState.encostFeatureSelection("load graph");

        // ASSERT
        Assertions.assertFalse(result);
    }

    // TESTING: encostFeatureSelection() method
    // EXPECTED: false is returned
    @Test
    @DisplayName("Testing encostFeatureSelection() for input 'dfaf6745#$#$'")
    public void invalidOptionOther() {

        // ACT
        Boolean result = featureOptionsState.encostFeatureSelection("dfaf6745#$#$");

        // ASSERT
        Assertions.assertFalse(result);
    }
}
