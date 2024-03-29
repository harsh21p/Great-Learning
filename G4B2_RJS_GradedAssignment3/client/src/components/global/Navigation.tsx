import { NavLink } from 'react-router-dom';
import { Container, Navbar, Nav } from 'react-bootstrap';
const Navigation = () => {
    return (

        <Navbar bg="dark" expand="lg">
            <Container >
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="me-auto">
                        <Navbar.Brand as={NavLink} to="/"></Navbar.Brand>
                        <Nav.Link as={NavLink} to="/coming-soon">Coming Soon</Nav.Link>
                        <Nav.Link as={NavLink} to="/movies-in-theaters">Movies in theaters</Nav.Link>
                        <Nav.Link as={NavLink} to="/top-rated-india">Top Rated India</Nav.Link>
                        <Nav.Link as={NavLink} to="/top-rated-movies">Top Rated Movies</Nav.Link>
                        <Nav.Link as={NavLink} to="/favourites">Favourites</Nav.Link>
                    </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    )
};





export default Navigation;