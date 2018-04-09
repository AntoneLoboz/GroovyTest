package groovytest

class Colleges {

    String name

    @Override
    String toString() {
        return name
    }
    static hasMany = [sudent: Students]

    static constraints = {
        name blank: false, unique: true
    }
}
