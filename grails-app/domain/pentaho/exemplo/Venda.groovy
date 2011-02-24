package pentaho.exemplo

class Venda {

	Pessoa cliente
	List itensDeVenda
	
	static hasMany = [itensDeVenda:ItemVenda]
	static transients = ['valor']
    
	static mapping = {
		itensDeVenda lazy:false
	}
	
	def getValor(){
		def valor =0d
		itensDeVenda.each{
			valor+= it.valor
		}
		return valor
	}
}
