import React,{useState} from 'react';
import {Link} from 'react-router-dom';
import {Card,Tab,Carousel, Container,Tabs, Row, Col} from 'react-bootstrap';
export default function Home(){
    const style={
        border:'4px',
        padding:'25px',
        boxShadow: '5px  5px 15px black'
      }
    const [key, setKey] = useState('admin');
        return(
           
            <Container>
            <Card className="text-center">
                <Card.Header style={{fontSize: "40px",fontWeight: "bold",backgroundColor:"#E4E3E3"}}>Hotel Management System</Card.Header>
            </Card>
            <Tabs style={{boxShadow:'5px 5px 15px black'}} variant="tabs" activeKey={key} onSelect={(k) => setKey(k)}>
                <Tab style={{boxShadow:'5px 5px 15px black'}} eventKey="admin" title="Admin">
                <Card style={style}>
                            <Card.Body>
                            <Card.Title>Admin</Card.Title>
                            <Card.Text>
                                Admin can access details of users and rooms. Only he has the privileges of adding and editing those details.
                            </Card.Text>
                            <Link to="/admin" className="btn btn-primary">Log in as Admin</Link>
                            </Card.Body>
                        </Card>
                </Tab>
                <Tab style={{boxShadow:'5px 5px 15px black'}} eventKey="librarian" title="Manager">
                <Card style={style}>
                            <Card.Body>
                            <Card.Title>Manager</Card.Title>
                            <Card.Text>
                                Manager can view all orders and other related details{' '}
                            </Card.Text>
                            <Link to="/manager" className="btn btn-primary">Log in as Manager</Link>
                            </Card.Body>
                        </Card>
                </Tab>
                <Tab style={{boxShadow:'5px 5px 15px black'}} eventKey="instructor" title="Receptionist">
                <Card style={style}>
                            <Card.Body>
                            <Card.Title>Receptionist</Card.Title>
                            <Card.Text>
                                Receptionist can book the rooms and also look after guests.
                            </Card.Text>
                            <Link to="/receptionist" className="btn btn-primary">Log in as Receptionist</Link>
                            </Card.Body>
                        </Card>
                </Tab>
              
  
                </Tabs>
                <Row><br/></Row>
                <Col>
                <Carousel>
                    <Carousel.Item interval={1500}>
                        <img className="" style={{height: "250px",backgroundColor:"black"}} 
                        src="https://www.thesaurus.com/e/wp-content/uploads/2016/12/1000x700-love-libraries-quotes-2-790x310.jpg" 
                        alt="first-slide"></img>
                    </Carousel.Item>
                    <Carousel.Item interval={1500}>
                        <img className="" style={{height: "250px",backgroundColor:"black"}} 
                        src="https://www.thesaurus.com/e/wp-content/uploads/2016/12/1000x700-love-libraries-quotes-1-790x310.jpg" 
                        alt="second-slide"></img>
                    </Carousel.Item>
                    <Carousel.Item interval={1500}>
                        <img className="" style={{height: "250px",backgroundColor:"black"}} 
                        src="https://www.thesaurus.com/e/wp-content/uploads/2016/12/1000x700-love-libraries-quotes-6-790x310.jpg" 
                        alt="third-slide"></img>
                    </Carousel.Item>
                    <Carousel.Item interval={1500}>
                        <img className="" style={{height: "250px",backgroundColor:"black"}} 
                        src="https://www.thesaurus.com/e/wp-content/uploads/2016/12/1000x700-love-libraries-quotes-9-790x310.jpg" 
                        alt="fourth-slide"></img>
                    </Carousel.Item>
                    <Carousel.Item interval={1500}>
                        <img style={{height: "250px",backgroundColor:"black"}} className="" 
                        src="https://www.thesaurus.com/e/wp-content/uploads/2016/12/1000x700-love-libraries-quotes-11-790x310.jpg" 
                        alt="five-slide"></img>
                    </Carousel.Item>
                    </Carousel>
                    </Col>
            </Container>
        );
}