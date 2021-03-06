package org.teiid.translator.jdbc.druid;

import org.teiid.language.Command;
import org.teiid.translator.ExecutionContext;
import org.teiid.translator.ResultSetExecution;
import org.teiid.translator.TranslatorException;
import org.teiid.translator.jdbc.JDBCBaseExecution;
import org.teiid.translator.jdbc.JDBCExecutionFactory;
import org.teiid.translator.jdbc.JDBCQueryExecution;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

/**
 * Query execution class for Apache Druid.
 * Created by Don Krapohl 04/02/2021
 */
public class DruidQueryExecution extends JDBCQueryExecution {
    public DruidQueryExecution(Command command, Connection connection, ExecutionContext context, JDBCExecutionFactory env) {
        super(command, connection, context, env);
    }

    @Override
    public void execute() throws TranslatorException {
        try {
            super.execute();
        }
        catch (Exception translatorException)
        {
			// Avatica jdbc error message is not usually at the top of the stack
            throw new TranslatorException(translatorException.getCause());

        }

    }
}
