package tutorial.testutil;

import java.io.File;
import java.io.FileNotFoundException;

import org.dbunit.DataSourceBasedDBTestCase;
import org.dbunit.IDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.excel.XlsDataSet;
import org.springframework.util.ResourceUtils;

public abstract class TutorialDataSourceBasedDBTestCase extends DataSourceBasedDBTestCase {

    @Override
    protected void closeConnection(IDatabaseConnection connection) throws Exception {

        assertNotNull( "DatabaseTester is not set", getDatabaseTester() );
        IDatabaseTester tester = getDatabaseTester();
        if (!tester.getConnection().getConnection().isClosed()) {
            tester.getConnection().close();
        }
    }
    
    @Override
    protected IDataSet getDataSet() throws Exception {
        return new XlsDataSet(getDataFile());
    }
    
    abstract protected String getFilePath();
    
    protected File getDataFile() throws FileNotFoundException {
        File xlsFile = ResourceUtils.getFile(getFilePath());
        return xlsFile;
    }
}
