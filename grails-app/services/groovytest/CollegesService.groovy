package groovytest

import grails.gorm.services.Service

@Service(Colleges)
interface CollegesService {

    Colleges get(Serializable id)

    List<Colleges> list(Map args)

    Long count()

    void delete(Serializable id)

    Colleges save(Colleges colleges)

}