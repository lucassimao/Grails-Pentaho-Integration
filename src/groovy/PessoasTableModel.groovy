import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import pentaho.exemplo.*

public class PessoasTableModel extends DefaultTableModel {
	
	
  public Vector<Object> getColumnNames() {
			List columnNames = ["Id", "Nome", "Email"]
			Vector<Object> names = new Vector<Object>();
			columnNames.each { c->
				names.add(c);
			}
			return names;  	
	}  
	
  public PessoasTableModel(TipoPessoa tipo) {
			super();
			Vector<Vector<Object>> linhas = new Vector<Vector<Object>>()
			Pessoa.findAllByTipoPessoa(tipo).each{ p->
					Vector<Object> linha = new Vector<Object>();
					linha.add(p.id)
					linha.add(p.nome)
					linha.add(p.email)
					linhas.add(linha)
			}
			
			setDataVector(linhas, getColumnNames());
  }  

  public PessoasTableModel() {
			super();
			Vector<Vector<Object>> linhas = new Vector<Vector<Object>>()
			Pessoa.list().each{ p->
					Vector<Object> linha = new Vector<Object>();
					linha.add(p.id)
					linha.add(p.nome)
					linha.add(p.email)
					linhas.add(linha)
			}
			setDataVector(linhas, getColumnNames());
  } 
}