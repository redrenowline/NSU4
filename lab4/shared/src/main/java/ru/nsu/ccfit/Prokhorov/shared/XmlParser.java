package ru.nsu.ccfit.Prokhorov.shared;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
public class XmlParser extends Parser{

    public XmlParser(){

    }

    public Element addUserModel(Document document, UserHandler userinfo){
        Element rootElement = document.createElement(XmlParsersStrings.rootUser);
        Element nicknameElement  = document.createElement(XmlParsersStrings.nickNameElement);
        Element sessionID = document.createElement(XmlParsersStrings.sessionID);

        rootElement.appendChild(nicknameElement);
        rootElement.appendChild(sessionID);

        nicknameElement.setNodeValue(userinfo.getNickname());
        sessionID.setNodeValue(userinfo.getSessionID());
        return rootElement;
    }

    public byte[] createMessageDocument(Chunk chunk) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element rootElement = document.createElement(XmlParsersStrings.rootElement);
        document.appendChild(rootElement);

        Element tagElement = document.createElement(XmlParsersStrings.tagElement);
        tagElement.setNodeValue(chunk.getTag().toString());
        rootElement.appendChild(tagElement);

        Element userElement = addUserModel(document, chunk.getUserInfo());
        rootElement.appendChild(userElement);

        Element textElement = document.createElement(XmlParsersStrings.textElement);
        textElement.setNodeValue(chunk.getMsg());
        rootElement.appendChild(textElement);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        StreamResult result = new StreamResult(baos);
        transformer.transform(source, result);
        return baos.toByteArray();
    }

    @Override
    public byte[] convertChunk(Chunk chunk) {
        try {
            return createMessageDocument(chunk);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }

    private Chunk getDocument(byte[] bytes) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new ByteArrayInputStream(bytes));

        NodeList nicknameElements = document.getDocumentElement().getElementsByTagName(XmlParsersStrings.nickNameElement);
        Node nicknameElement = nicknameElements.item(0);
        String nickname = nicknameElement.getNodeValue();

        NodeList sessionIdElements = document.getDocumentElement().getElementsByTagName(XmlParsersStrings.sessionID);
        Node sessionIdElement = sessionIdElements.item(0);
        String sessionId = sessionIdElement.getNodeValue();

        NodeList textElements = document.getDocumentElement().getElementsByTagName(XmlParsersStrings.nickNameElement);
        Node textElement = textElements.item(0);
        String text = textElement.getNodeValue();

        NodeList tagElements = document.getDocumentElement().getElementsByTagName(XmlParsersStrings.nickNameElement);
        Node tagElement = tagElements.item(0);
        String tag = textElement.getNodeValue();

        Chunk msg = new Chunk(new UserHandler(nickname, sessionId), text, Chunk.TAG.valueOf(tag));
        return msg;
    }

    @Override
    public Chunk deconvertChunk(byte[] bytes) {
        try {
            return getDocument(bytes);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }
}
