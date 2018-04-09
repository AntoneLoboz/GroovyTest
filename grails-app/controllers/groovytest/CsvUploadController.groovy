package groovytest

class CsvUploadController {

    static allowedMethods = [upload: "POST"]
    static defaultAction = 'index'
    static List parsErrors = new LinkedList()

    def index() { }

    def upload() {
        parsErrors.clear()
        request.getFile( 'file' )
                .inputStream
                .splitEachLine(',') { fields ->
            def student = new Students(email: fields[0].trim(),
                    firstName: fields[1].trim(),
                    lastName: fields[2].trim(),
                    documentId: fields[3].trim(),
                    college: Colleges.find("from Colleges as col where col.name=?",[fields[4].trim()])
            )
            if (!student.save(validate: true)) {
                student.errors.each {
                    parsErrors.add(it.toString())
                }
            }
        }
        if(parsErrors.empty){
            redirect(controller: "Students", action: "index")
        }else {
            redirect(action: "errors")
        }
    }

    def errors() {
        [parsErrors: parsErrors]
    }

}
