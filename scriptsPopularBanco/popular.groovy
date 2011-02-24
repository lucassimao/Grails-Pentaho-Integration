import pentaho.exemplo.*

def item1 = new ItemVenda()
item1.produto ='Arroz'
item1.valor = 5

def item2 = new ItemVenda()
item2.produto ='Feijao'
item2.valor = 2

def item3 = new ItemVenda()
item3.produto ='Macarrao'
item3.valor = 1

def p = new Pessoa()
p.nome = 'Pessoa 2'
p.tipoPessoa = TipoPessoa.Fisica
p.email='jjjj'
assert p.save()

def v = new Venda()
v.cliente = p
v.itensDeVenda = [item1,item2]
assert v.save()
