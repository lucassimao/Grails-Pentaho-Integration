import org.pentaho.reporting.engine.classic.core.modules.output.pageable.pdf.PdfReportUtil;
import org.pentaho.reporting.libraries.resourceloader.Resource;
import org.pentaho.reporting.libraries.resourceloader.ResourceException;
import org.pentaho.reporting.libraries.resourceloader.ResourceManager;
import org.pentaho.reporting.engine.classic.core.*
import org.pentaho.reporting.engine.classic.core.parameters.*
import org.springframework.context.ResourceLoaderAware
import org.springframework.core.io.ResourceLoader
import javax.swing.table.*
import org.pentaho.reporting.engine.classic.core.MasterReport


public class MeuFactory extends TableDataFactory{
	public MeuFactory(){
		super()
	}
	
	public TableModel queryData(String query, DataRow parameters){
		if (query == 'QueryItens'){
			return new ItensTableModel(parameters['idVenda'])
		}else
				return super.queryData(query,parameters)
	}

}