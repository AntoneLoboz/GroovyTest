package groovytest

class Students {

    String email
    String firstName
    String lastName
    String documentId
    //String collegeName

    @Override
    String toString() {
        return firstName + " " + lastName
    }
    static belongsTo = [college: Colleges]

    static constraints = {
        email email: true, nullable: true
        firstName blank: false
        lastName blank: false
        documentId nullable: true
        //collegeName blank: false
    }
}
