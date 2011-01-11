package pentaho.exemplo

class PessoaController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [pessoaInstanceList: Pessoa.list(params), pessoaInstanceTotal: Pessoa.count()]
    }

    def create = {
        def pessoaInstance = new Pessoa()
        pessoaInstance.properties = params
        return [pessoaInstance: pessoaInstance]
    }

    def save = {
        def pessoaInstance = new Pessoa(params)
        if (pessoaInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'pessoa.label', default: 'Pessoa'), pessoaInstance.id])}"
            redirect(action: "show", id: pessoaInstance.id)
        }
        else {
            render(view: "create", model: [pessoaInstance: pessoaInstance])
        }
    }

    def show = {
        def pessoaInstance = Pessoa.get(params.id)
        if (!pessoaInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'pessoa.label', default: 'Pessoa'), params.id])}"
            redirect(action: "list")
        }
        else {
            [pessoaInstance: pessoaInstance]
        }
    }

    def edit = {
        def pessoaInstance = Pessoa.get(params.id)
        if (!pessoaInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'pessoa.label', default: 'Pessoa'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [pessoaInstance: pessoaInstance]
        }
    }

    def update = {
        def pessoaInstance = Pessoa.get(params.id)
        if (pessoaInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (pessoaInstance.version > version) {
                    
                    pessoaInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'pessoa.label', default: 'Pessoa')] as Object[], "Another user has updated this Pessoa while you were editing")
                    render(view: "edit", model: [pessoaInstance: pessoaInstance])
                    return
                }
            }
            pessoaInstance.properties = params
            if (!pessoaInstance.hasErrors() && pessoaInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'pessoa.label', default: 'Pessoa'), pessoaInstance.id])}"
                redirect(action: "show", id: pessoaInstance.id)
            }
            else {
                render(view: "edit", model: [pessoaInstance: pessoaInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'pessoa.label', default: 'Pessoa'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def pessoaInstance = Pessoa.get(params.id)
        if (pessoaInstance) {
            try {
                pessoaInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'pessoa.label', default: 'Pessoa'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'pessoa.label', default: 'Pessoa'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'pessoa.label', default: 'Pessoa'), params.id])}"
            redirect(action: "list")
        }
    }
}
