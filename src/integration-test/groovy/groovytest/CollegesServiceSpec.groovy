package groovytest

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CollegesServiceSpec extends Specification {

    CollegesService collegesService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Colleges(...).save(flush: true, failOnError: true)
        //new Colleges(...).save(flush: true, failOnError: true)
        //Colleges colleges = new Colleges(...).save(flush: true, failOnError: true)
        //new Colleges(...).save(flush: true, failOnError: true)
        //new Colleges(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //colleges.id
    }

    void "test get"() {
        setupData()

        expect:
        collegesService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Colleges> collegesList = collegesService.list(max: 2, offset: 2)

        then:
        collegesList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        collegesService.count() == 5
    }

    void "test delete"() {
        Long collegesId = setupData()

        expect:
        collegesService.count() == 5

        when:
        collegesService.delete(collegesId)
        sessionFactory.currentSession.flush()

        then:
        collegesService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Colleges colleges = new Colleges()
        collegesService.save(colleges)

        then:
        colleges.id != null
    }
}
