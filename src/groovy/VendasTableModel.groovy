import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import pentaho.exemplo.*

 
public class VendasTableModel extends DefaultTableModel {
	
	public Vector<Object> getColumnNames(){
		List columns = ["Id","Cliente","Valor"]
		Vector<Object> names = new Vector<Object>();
		columns.each{ c->
			 names.add(c); 
		}
		return names;
	}  
	
	public VendasTableModel() {
		super();
		Vector<Vector<Object>> linhas = new Vector<Vector<Object>>()
		
		Venda.list().each{ v->
			Vector<Object> linha = new Vector<Object>();
			
			linha.add(v.id)
			linha.add(v.cliente.nome)
			linha.add(v.valor)		
			
			linhas.add(linha)
		}
		
		setDataVector(linhas, getColumnNames());
	}  
  

  }