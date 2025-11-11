-- ================================================================
--  FLYWAY MIGRATION SCRIPT - V2__INSERT_SEED.sql
--  Projeto: ReUp - Upskilling & Reskilling System
--  Banco: PostgreSQL
--  Objetivo: Popular tabelas com dados iniciais
-- ================================================================

-- ================================================================
-- USUÁRIOS
-- ================================================================
INSERT INTO usuarios (name, email, area_atuacao, nivel_carreira, roles)
VALUES
    ('Enzo Rodrigues', 'enzo@reup.com', 'Tecnologia', 'JUNIOR', 'ALUNO'),
    ('Rafael Cristofali', 'rafael@reup.com', 'Gestão de Pessoas', 'PLENO', 'PROFISSIONAL');

-- ================================================================
-- TRILHAS
-- ================================================================
INSERT INTO trilhas (name, descricao, nivel, carga_horaria, foco_principal)
VALUES
    ('Trilha Backend Java', 'Aprenda a desenvolver APIs RESTful com Spring Boot e PostgreSQL.', 'INTERMEDIARIO', 40, 'Java'),
    ('Trilha Soft Skills', 'Desenvolva competências de liderança, comunicação e trabalho em equipe.', 'INICIANTE', 20, 'Comunicação');

-- ================================================================
-- COMPETÊNCIAS
-- ================================================================
INSERT INTO competencias (nome, descricao, categoria)
VALUES
    ('Programação Orientada a Objetos', 'Compreensão dos princípios de POO em linguagens modernas.', 'Desenvolvimento de Software'),
    ('Comunicação Eficaz', 'Capacidade de transmitir ideias de forma clara e empática.', 'Soft Skills');

-- ================================================================
-- RELACIONAMENTO N:N: TRILHA x COMPETÊNCIA
-- ================================================================
-- Vincula as competências às trilhas correspondentes
INSERT INTO trilha_competencia (trilha_id, competencia_id)
VALUES
    (1, 1), -- Backend Java ↔ POO
    (2, 2); -- Soft Skills ↔ Comunicação Eficaz

-- ================================================================
-- MATRÍCULAS
-- ================================================================
-- Associa usuários às trilhas
INSERT INTO matriculas (usuario_id, trilha_id)
VALUES
    (1, 1), -- Enzo matriculado na trilha Backend Java
    (2, 2); -- Rafael matriculado na trilha Soft Skills

