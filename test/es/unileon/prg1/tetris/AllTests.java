package es.unileon.prg1.tetris;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TetrisTest.class, ArrayMxNTest.class, ArrayNxNTest.class, BlockTest.class,
BlockITest.class, BlockJTest.class, BlockLTest.class, BlockSTest.class, BlockTTest.class,
BlockZTest.class, BoardTest.class })
public class AllTests {

}