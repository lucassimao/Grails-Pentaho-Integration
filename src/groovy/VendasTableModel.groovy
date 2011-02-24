import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import pentaho.exemplo.*

class ItensTableModel extends DefaultTableModel {
	
	public Vector<Object> getColumnNames(){
		List columns = ["Id","Produto","Valor"]
		Vector<Object> names = new Vector<Object>();
		columns.each{ c->
			 names.add(c); 
		}
		return names;
	}  
	
	public ItensTableModel() {
		super();
		Vector<Vector<Object>> linhas = new Vector<Vector<Object>>()
		
		ItemVenda.list().each{ v->
			Vector<Object> linha = new Vector<Object>();
			
			linha.add(v.id.toString())
			linha.add(v.produto)
			linha.add(v.valor.toString())		
			
			linhas.add(linha)
		}
		
		setDataVector(linhas, getColumnNames());
	}  
  }
  
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