import React, { useEffect, useState } from 'react';
import { useAuth } from '../../contexts/AuthContext';
import styles from './UserAvaliacoes.module.css';
import { useNavigate } from 'react-router-dom';
import { renderItem } from "./avaliacaoListagem";
import { getComentariosUser } from "../../services/avaliacoesService";
import DataList from '../../components/DataList';

function UserAvaliacoes() {
    const { user } = useAuth();
    const [loading, setLoading] = useState(false);
    const navigate = useNavigate();

    const [disc, setDisc] = useState([]);

    useEffect(() => {
        async function fetchData() {
            if (user) {
                setLoading(true);
                const data = (await getComentariosUser(user.id)).data;
                setDisc(data);
                setLoading(false);
            }

        }

        fetchData();
    }, [user]);

    return (
        <div className={styles.container}>
            <div className={styles.content}>
                <div className={styles.header}>
                    <ul className={styles.userNav}>
                        <li className={styles.active}><span onClick={() =>
                            navigate("/userAvaliacoes")}>Avaliações</span></li>
                        <li><span onClick={() =>
                            navigate("/userComentarios")}>Comentários</span></li>
                        <li><span onClick={() =>
                            navigate("/user")}>Perfil</span></li>
                    </ul>
                </div>

                <div className={styles.itens}>
                    <DataList
                        data={disc}
                        loading={loading}
                        render={(item) => renderItem(item, navigate)
                        }
                    />
                </div>
            </div>
        </div>
    );
}

export default UserAvaliacoes;