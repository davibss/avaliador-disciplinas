import React, { useEffect, useState } from "react";
import styles from "./Disciplina.module.css";
import DataList from "../../components/DataList";
import { getAll } from "../../services/disciplinaService";
import Dropdown from "../../components/Dropdown";
import { atributosDisciplina } from "../../services/DadosEstaticos";
import { RenderItem } from "./itemListagem";
import { useAuth } from '../../contexts/AuthContext';

function DisciplinaIndex() {
  const [disc, setDisc] = useState([]);
  const [loading, setLoading] = useState(false);
  const [atributo, setAtributo] = useState();
  const [text, setText] = useState("");
  const { user } = useAuth();

  useEffect(() => {
    async function fetchData() {
      setLoading(true);
      const data = await getAll(atributo, text);
      setDisc(data);
      setLoading(false);
    }

    (async() => {
      await fetchData();
    })();
  }, [atributo, text]);

  return (
    <div className={styles.container}>
      <div className={styles.content}>
        <div className={styles.header}>
          <span>Lista de Disciplinas</span>
        </div>
        <div className={styles.filter}>
          <input
            type="text"
            id="nome"
            placeholder="Procure por uma disciplina"
            onChange={(e) => {
              setText(e.target.value);
            }}
          />
          <div className={styles.dropdown}>
            <Dropdown
              data={atributosDisciplina()}
              placeholder={"Selecione um filtro"}
              value="value"
              label="text"
              onChange={setAtributo}
            />
          </div>
        </div>
        <div className={styles.indexContent}>
            <DataList 
              data={disc} 
              loading={loading} 
              render={item => RenderItem({item, isAdmin: user === undefined ? false : user.isAdmin })} 
            />
        </div>
      </div>
    </div>
  );
}

export default DisciplinaIndex;
