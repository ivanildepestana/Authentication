package br.ce.imp.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.imp.test.TestApi;

@RunWith(Suite.class)
@SuiteClasses({
	TestApi.class
	
})
public class TestSuite {

}