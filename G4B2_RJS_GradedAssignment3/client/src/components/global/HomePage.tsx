import { useEffect, useState } from "react";
import { menuData } from "../../services/movieService";
import PageNotFound from "./PageNotFound";
import Loader from "../common/Loader";
import './homePage.css'

const HomePage = () => {
  const imgArray = ["1.jpg", "2.jpg", "3.jpg", "4.jpg", "5.jpg"];

  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<null | Error>(null);
  const [menu, setMenu] = useState<string[]>([]);

  useEffect(() => {
    const helper = async () => {
      setLoading(true);
      setError(null);
      try {
        const fetchMenu = await menuData();
        setMenu(fetchMenu);
      } catch (error) {
        setError(error as Error);
      } finally {
        setLoading(false);
      }
    };

    helper();
  }, []);

  return (
    <>
      {loading && (
        <>
          <Loader message="Loading..." size="large"></Loader>
        </>
      )}
      {!loading && error && (
        <>
          <PageNotFound></PageNotFound>
        </>
      )}
      {menu.length !== 0 && !loading && !error && (
        <>
          <div className="logo">
           
          </div>
        </>
      )}
    </>
  );
};

export default HomePage;
