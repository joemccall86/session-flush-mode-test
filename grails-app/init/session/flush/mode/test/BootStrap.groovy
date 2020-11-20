package session.flush.mode.test

class BootStrap {
    
    def sessionFactory

    def init = { servletContext ->

        def book = new Book(title: 'Foo', author: 'Bar') // Should fail because of no description
        def previousHibernateFlushMode = sessionFactory.currentSession.hibernateFlushMode

        book.validate()
        assert sessionFactory.currentSession.hibernateFlushMode == previousHibernateFlushMode
    }
    def destroy = {
    }
}
