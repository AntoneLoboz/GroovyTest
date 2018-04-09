package groovytest

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CollegesController {

    CollegesService collegesService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond collegesService.list(params), model:[collegesCount: collegesService.count()]
    }

    def show(Long id) {
        respond collegesService.get(id)
    }

    def create() {
        respond new Colleges(params)
    }

    def save(Colleges colleges) {
        if (colleges == null) {
            notFound()
            return
        }

        try {
            collegesService.save(colleges)
        } catch (ValidationException e) {
            respond colleges.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'colleges.label', default: 'Colleges'), colleges.id])
                redirect colleges
            }
            '*' { respond colleges, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond collegesService.get(id)
    }

    def update(Colleges colleges) {
        if (colleges == null) {
            notFound()
            return
        }

        try {
            collegesService.save(colleges)
        } catch (ValidationException e) {
            respond colleges.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'colleges.label', default: 'Colleges'), colleges.id])
                redirect colleges
            }
            '*'{ respond colleges, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        collegesService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'colleges.label', default: 'Colleges'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'colleges.label', default: 'Colleges'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
